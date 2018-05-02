package hackerranck.easy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ACMICPCTeam {
	static int[] acmTeam(String[] topic) {
        // Complete this function
//		System.out.println("Received length is: " + topic.length);
		
		int[] result = new int[2];
		int maxTopic = 0;
		int maxTeam = 0;
		
		for(int i = 0; i < topic.length; i++) {
			for(int j = i + 1; j < topic.length; j++) {
				char[] first = topic[i].toCharArray();
				char[] second = topic[j].toCharArray();
				
				int matchTopic = 0;
				for(int x = 0; x < first.length; x ++) {
					if(first[x] == '1' || second[x] == '1') {
						matchTopic++;
					}
				}
				if(matchTopic > maxTopic) {
					maxTopic = matchTopic;
					maxTeam = 1;
				} else if(matchTopic == maxTopic) {
					maxTeam++;
				}
			}
		}
		
		result[0] = maxTopic;
		result[1] = maxTeam;
		return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // attendees
        int m = in.nextInt(); // topics
        String[] topic = new String[n];
        for(int topic_i = 0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        int[] result = acmTeam(topic);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
