package com.jason.exercises.jdk.work;

import com.jason.exercises.jdk.work.common.Paths;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public abstract class Resources {

    List<Paths> data = null;

    public Resources() {
        this.data = createData("/Users/jason/Workspace/exercises/base/src/test/java/com/jason/exercises/jdk/work/paths.txt");
    }

    /**
     * 初始化数据
     *
     * @param filePath
     * @return
     */
    public List<Paths> createData(String filePath) {
        List<Paths> pathsList = new LinkedList<>();
        try {
            File file = new File(filePath);
            InputStream is = new FileInputStream(file);
            BufferedReader read = new BufferedReader(new InputStreamReader(is));
            String temp;
            while ((temp = read.readLine()) != null) {
                String[] words = temp.split("#");
                pathsList.add(new Paths(words[0], Long.valueOf(words[1])));
            }
            read.close();
            is.close();
        } catch (IOException e) {
            System.out.println("error in read file");
        }
        return pathsList;
    }

    public abstract Set<Long> find(Set<Long> set);
}
