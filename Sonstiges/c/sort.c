#include <stdio.h>
#include <stdlib.h> 
#include <time.h> 
#include <stdbool.h>

const int LB = 1, UB = 1000000;
const int LENGTH = 10000;
const int PRINT_LIMIT = 50;

void printArray(int ar[]) {
   for (int i = 0; i < PRINT_LIMIT; i++) {
      printf("%d ", ar[i]);
   }
   
   printf("\n");
}

int main(){
   srand(time(0)); 

   int numbers[LENGTH];
   
   for (int i = 0; i < LENGTH; i++) {
      numbers[i] = rand() % (UB - LB + 1) + LB; 
   }
   
   printf("Unsorted: ");
   printArray(numbers);
   
   // Bubble Sort
   bool sortingDone = false;
   int temp;
   while (!sortingDone) {
      sortingDone = true;
      for (int i = 0; i < LENGTH - 1; i++) {
         if (numbers[i] > numbers[i + 1]) {
            sortingDone = false;
            temp = numbers[i + 1];
            numbers[i + 1] = numbers[i];
            numbers[i] = temp;
         }
      }
   }
   
   printf("Sorted: ");
   printArray(numbers);
   
   return 0;
}
