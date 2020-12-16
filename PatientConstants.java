package com.eshwarne.docblock;

public class PatientConstants {
    public static final String[] SYMPTOMSTRING = new String[]{"headache","cough","diarhea","vomitting","nausea","fever","constipation","running nose","swelling","inflammation","shivering","seizure","unconsiousness","weight loss","fatigue","pain","apetite loss","throat ache","bloating","bleeding"};
    public static String getSymptoms(String binaryString){
        StringBuilder sb = new StringBuilder();
        char[] map = binaryString.toCharArray();
        int pointer = 0;
        for(char c:map){
            if(c=='1'){
                sb.append(SYMPTOMSTRING[pointer]+",");
            }
            pointer+=1;
        }
        return sb.toString();
    }
}
