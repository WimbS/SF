package com.wumeng.E;

import java.util.Scanner;

public class A1060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while(input.hasNext()){
			
			String str = input.nextLine();
			char a[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' ',','};
			char b[] = {'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',' ',','};
			
			if(str.trim().equals("START")){
				continue;
			}else if(str.trim().equals("END")){
				continue;
			}else if(str.trim().equals("ENDOFINPUT")){
				String pp = sb.toString();
				System.out.print(pp);
				return;
			}else{
				char []strr = str.toCharArray();
				int len = strr.length;
				for(int j=0;j<strr.length;j++){
					for(int i=0;i<a.length;i++){
						if(a[i] == strr[i]){
							sb.append(b[i]);
							break;
						}
					}
				}
				
				sb.append('\n');
			}
			
			//System.out.print(a);
		}
		

		
	}
}

//C++_AC´úÂë


//#include<cstdio>
//#include<cstring>
//#include<algorithm>
//#include<cmath>
//using namespace std;
//
//char a[205],str[205];
//char s[27]={'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'};
//int main()
//{
//    while(gets(a))
//    {
//        if(strcmp(a,"ENDOFINPUT")==0)
//        {
//            break;
//        }
//        if(strcmp(a,"START")==0)
//        {
//            gets(str);
//            int len=strlen(str);
//            for(int i=0;i<len;i++)
//            {
//                if(str[i]>='A'&&str[i]<='Z')
//                str[i]=s[str[i]-'A'];
//            }
//            printf("%s\n",str);
//        }
//    }
//    return 0;
//}

