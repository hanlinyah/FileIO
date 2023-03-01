package FileIOpractice;

import java.io.File;
import java.util.*;

public class finfilepractice {

    static Map<String,List<String>> findFiles=new LinkedHashMap<>();
    static int findfilesNum=0;
    public static void main(String[] args) {
        createTestFile.makefile();
        Scanner sc=new Scanner(System.in);
        System.out.println("請輸入搜尋檔案資料夾路徑，例如「 D:/test 」，輸入完成請按下Enter");
        String dir=sc.next();
        System.out.println("請輸入搜尋檔案名稱，例如「 testfile1 」，輸入完成請按下Enter");
        String fileName=sc.next();
        Map<String,List<String>> findFiles = searchFile(new File(dir), fileName);
        System.out.println("\n\n---------搜尋完成----------");
        System.out.println("共找到 "+findfilesNum+" 個檔案，路徑如下：");
        for(String fdir:findFiles.keySet()){
            System.out.println(fdir);
            for(String file:findFiles.get(fdir)){
                System.out.println("\t\t"+file);
            };
        }

    }

    private static Map<String,List<String>> searchFile(File dir, String fileName)  {
        List<String> ls=new ArrayList<>();
        System.out.println("---正在進行搜尋---");
        if(dir != null && dir.isDirectory()){
            System.out.println("\t---正在搜尋路徑："+dir);
            File[] files=dir.listFiles();
//            System.out.println("---check files---");
            if(files != null && files.length>0){
//                System.out.println("---file checked---");
                for (File file:files){
//                    System.out.println("---check is File?---");
                    if(file.isFile()){
                        System.out.println("\t\t---正在搜尋檔案:"+file.getAbsolutePath());
                        if(file.getName().contains(fileName)){
                            findfilesNum++;
                            ls.add(file.getName());
                            System.out.println("[目標檔案]:"+file.getAbsolutePath());
//                            Runtime r= Runtime.getRuntime();
//                            try {
//                                r.exec(file.getAbsolutePath());
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
                        }
                        if(ls.size()>0){
                            findFiles.put(dir.toString(),ls);
                        }
                    }else {
                        searchFile(file,fileName);
                    }
                }
            }else {
                System.out.println("---查無檔案---");
            }
        }else{
            System.out.println("---路徑錯誤---");
        }
        return findFiles;
    }
}
