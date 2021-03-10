import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 计算代码有效行数
 */
public class Main {
    public int calLine(List<File> files) {
        int res = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            for (File file:files) {
                if (file.getName().endsWith(".java") || file.getName().endsWith(".xml")) {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    String line = "";
                    boolean flag = false;
                    while ((line = br.readLine()) != null) {
                        line = line.trim();
                        if (line.startsWith("//")) {
                            continue;
                        } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                            flag = true;
                            continue;
                        } else if (line.startsWith("/*") && line.endsWith("*/")) {
                            continue;
                        } else if (flag) {
                            if (line.endsWith("*/")) {
                                flag = false;
                            }
                            continue;
                        }
                        res++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
