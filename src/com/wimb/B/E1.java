package com.wimb.B;

public class E1 {
	private static int a[] = {9,79,46,30,58,49};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new E1().sort(a,0,5);
		for(int k:a){
			System.out.print(k+" ");
		}
	}
	public void Bubble(int a[]){
		if(a == null)
			return ;
		int len = a.length;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len-i-1;j++){
				if(a[j+1]<a[j]){
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	public void QuickSort(int a[],int start,int end){
		int i = start;
		int j = end;
		if(i>=j)
			return;
		boolean flag = true;//true:--->   flase:<---
		while(i!=j){
			if(a[i]>a[j]){
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				flag = !flag;
			}
			if(flag){
				j--;
			}else{
				i++;
			}
		}
		i--;
		j++;
		QuickSort(a,start,i);
		QuickSort(a,j,end);
	}
	public void SelectSort(int a[]){
		int len = a.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(a[i]>a[j]){
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
	}
	//堆排序
	public void HeapSort(int a[]){
		int len = a.length;
		for(int i=0;i<len-1;i++){
			BuildMaxHeap(a,len-1-i);
			swap(a,0,len-i-1);
		}
	}
	public void BuildMaxHeap(int a[],int lastIndex){

		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k = i;
			int biggerIndex = 2*k+1;
			while(2*k+1 <= lastIndex){
				if(2*k+1<lastIndex){
					if(a[2*k+1] < a[2*k+2]){
						biggerIndex++;
					}
				}	
				if(a[biggerIndex] > a[k]){
					swap(a,k,biggerIndex);
				}else{
					break;
				}			
			}

		}
	}
	public void swap(int a[],int b,int c){
		int tmp = a[b];
		a[b] = a[c];
		a[c] = tmp;
	}
	//归并排序
	public int[] sort(int a[],int low,int high){
		int mid = (low+high)/2;
		if(low<high){
			sort(a,low,mid);
			sort(a,mid+1,high);
			merge(a,low,mid,high);
		}
		return a;
	}
	public void merge(int a[],int low,int mid,int high){
		int []tmp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		while(i<=mid&&j<=high){
			if(a[i]<a[j]){
				tmp[k++] = a[i++];
			}else{
				tmp[k++] = a[j++];
			}
		}
		while(i<=mid){
			tmp[k++] = a[i++];
		}
		while(j<=high){
			tmp[k++] = a[j++];
		}
		for(int x=0;x<tmp.length;x++){
			a[x+low] = tmp[x];
		}
	}
	//插入排序
	public void InsertSort(int a[]){
		if(a == null)
			return ;
		for(int i=0;i<a.length;i++){
			int index = -1;
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					index = j;
					break;
				}					
			}
			if(index != -1){
				int tmp = a[index];
				moveBackward(index, i-1, a); 
				a[index] = tmp;
			}
		}
	}
	private void moveBackward(int from, int to, int[] values) {
		for (int i=to + 1; i>from; i--){ 
			values[i] = values[i-1]; 
		}
	}
	//希尔排序
	public static void sort(int[] arrays){
        if(arrays == null || arrays.length <= 1){
            return;
        }
        //增量
        int incrementNum = arrays.length/2;
        while(incrementNum>=1){
            for(int i=0;i<arrays.length;i++){
                //进行插入排序
                for(int j=i;j<arrays.length-incrementNum;j=j+incrementNum){
                    if(arrays[j]>arrays[j+incrementNum]){
                        int temple = arrays[j];
                        arrays[j] = arrays[j+incrementNum];
                        arrays[j+incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum/2;
        }
    }
}
