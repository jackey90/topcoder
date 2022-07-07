package org.jackey.base;

import com.google.gson.Gson;
import org.jackey.support.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseCase {

    File file;
    FileReader fr;
    BufferedReader br;
    Map<Integer, String> inputMap = new HashMap();

    private void init() throws FileNotFoundException {
        try {
            String className = this.getClass().getSimpleName();
            file = new File( "src/test/resources/" + className + ".txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            for (int i = 0; i < 10000; i++) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                inputMap.put(i, line);
            }
        } catch (Exception e) {
            System.out.println("init error !" + e.getMessage());
        }
    }

    public Object doTest(String methodName) {
        Object obj = null;
        try {
            init();
            Method[] methods = this.getClass().getMethods();
            Method method = null;
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    method = m;
                    break;
                }
            }
            Class<?>[] types = method.getParameterTypes();
            Type[] genericTypes = method.getGenericParameterTypes();
            Object[] args = new Object[types.length];
            for (int i = 0; i < types.length; i++) {
                args[i] = getArg(i, genericTypes[i]);
            }
            obj = method.invoke(this, args);
            System.out.println(obj);
            return obj;
        } catch (Exception e) {
            System.out.println("doTest error " + e.getMessage());
        } finally {
            exit();

        }
        return obj;
    }

    public <T> T getArg(Integer index, Type type)  {
        String str = inputMap.get(index);
        Assert.check(str != null, "Arg null!");
        return new Gson().fromJson(str,type);
    }

    private void exit() {
        if (fr == null) {
            return;
        }
        try {
            fr.close();
        } catch (Exception e) {
            System.out.println("exit error !" + e.getMessage());
        }
    }

}
