package 堆;

import java.util.*;

public class TopK {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        if(strings==null||strings.length==0){
            return new String[][]{};
        }
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<strings.length;i++){
            map.put(strings[i],map.getOrDefault(strings[i],0)+1);
        }
        PriorityQueue<String> minorQueue=new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if(map.get(s1).equals(map.get(s2))){
                    //小顶堆要反着来
                    return s2.compareTo(s1);
                }else{
                    return map.get(s1)-map.get(s2);
                }
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(minorQueue.size()<k){
                minorQueue.add(entry.getKey());
            }else{
                if(map.get(entry.getKey())>map.get(minorQueue.peek())){
                    minorQueue.poll();
                    minorQueue.add(entry.getKey());
                }else if(map.get(entry.getKey()).equals(map.get(minorQueue.peek()))){
                    if(entry.getKey().compareTo(minorQueue.peek())<0){
                        minorQueue.poll();
                        minorQueue.add(entry.getKey());
                    }
                }
            }
        }
        String[][] res=new String[k][2];
        for(int i=k-1;i>=0;i--){
            res[i][0]=minorQueue.poll();
            res[i][1]=String.valueOf(map.get(res[i][0]));
        }
        return res;
    }
}