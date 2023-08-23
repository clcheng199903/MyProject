import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H5DataSetRead {
    @Test
    void readTest() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\clcheng\\Desktop\\110正样y向0.2g试验时域数据.unv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        for (int i=0;i<10;i++) {
            reader.readLine();
        }

        for (int i=0;i<6;i++) {
            reader.readLine();
        }

        boolean isHead = true;
        String line = null;
        int count = 16;

        List<List<String>> datasets = new ArrayList<>();

        List<String> dataset = null;
        while ((line = reader.readLine()) != null) {
            count++;
            if (line.contains("    -1")) {
                if (isHead) {
                    for (int i=0;i<12;i++) {
                        reader.readLine();
                    }
                    count += 12;

                    dataset = new ArrayList<>();
                } else {
                    System.out.println("到尾了" + count);
                    System.out.println(dataset.size());
                    datasets.add(dataset);
                }
//                System.out.println("读取到-1，在" + count + "行，是头" + isHead);
                isHead = !isHead;
            } else {
                dataset.add(line);
            }


//            String[] strings = line.split("\\s+");
//
//            for (String s : strings) {
//                if (s.equals("-1")) {
//
//                    System.out.println("读取到-1，在" + count + "行，是头" + isHead);
//                    isHead = !isHead;
//                }
//            }
        }

        System.out.println(datasets.size());
    }

    @Test
    void h5splitTest() throws IOException {




        FileInputStream fis = new FileInputStream("C:\\Users\\clcheng\\Desktop\\110正样y向0.2g试验时域数据.unv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        boolean isHead = true;

        List<List<String>> datasets = new ArrayList<>();

        List<String> dataset = null;
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains("    -1")) {
                if (isHead) {
                    dataset = new ArrayList<>();
                } else {
                    datasets.add(dataset);
                }
                isHead = !isHead;
            } else {
                dataset.add(line);
            }
        }

        // TODO: 处理两个属性
        datasets.remove(0);
        datasets.remove(0);

        // TODO: 处理Dataset整体
        for (List<String> data : datasets) {
            String s = data.get(1);
            String[] strings = s.split("\\s+");
            String name = strings[2];  // 测点名称
            int size = data.size();
            float[][] h5Dataset = new float[size - 12][6]; // 测点数据集
            for(int i = 0; i < size - 12;i++) {
                String[] values = data.get(i + 12).trim().split("\\s+");
                for (int j=0;j<6;j++) {
                    float value = Float.parseFloat(values[j]);
                    h5Dataset[i][j] = value;
                }
            }

            float[] ends = h5Dataset[h5Dataset.length - 1];
            int zeroCount = 0;
            for (int i = 5;i>=0;i--){
                if (ends[i] != 0) {
                    break;
                }
                zeroCount++;
            }
            int count = h5Dataset.length * 6 - zeroCount; // 测点的点位数量
            System.out.println(name);
            System.out.println(count);
            System.out.println(Arrays.toString(h5Dataset[size - 12 - 1]));


        }
    }
}
