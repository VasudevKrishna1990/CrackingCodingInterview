/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
#include<vector>
#include<stack>
using namespace std;

void print(vector<int> a ,int N){
    if(N == 1){
        cout<< a.at(N-1)<< "," ;
        return;
    }
    print(a,N-1);
    cout<< a.at(N-1) <<",";
}

vector<int>mergeA(vector<int>b,int N,int A){
    if(N == 0 || b.at(N-1) < A ){
        b.push_back(A);
        return b;
    }
    int x = b.at(N-1); 
    b.pop_back();
    vector<int>temp = mergeA(b,N-1,A);
    temp.push_back(x);
    return temp;
    
}

vector<int>sortA(vector<int>a,int N){
    
    if(N == 1)
        return a;
    int temp = a.at(N-1);
    a.pop_back();
    vector<int>b = sortA(a,N-1);
    b = mergeA(b,b.size(),temp);
    return b;
    
}

void deleteE(stack<int>&s,int N,int mid){
        
        if(N == 0)
        return;
        cout<< N << " " << mid<<endl;
        if(N == mid){
            s.pop();
            return;
        }
        
        int temp = s.top();
        s.pop();
        deleteE(s,N-1,mid);
        s.push(temp);
        
    }
    void deleteMid(stack<int>&s, int sizeOfStack)
    {
        int mid = sizeOfStack /2 + 1;
        deleteE(s,sizeOfStack,mid);
    }

void printStack(stack<int>s,int N){
    
    if(N == 1){
        cout<< s.top() << " " ;
        s.pop();
        return;
    }
    
    int temp = s.top();
    s.pop();
    
    printStack(s,N-1);
    cout<<temp <<" " ;
}
void reverseStack(stack<int>s,int N,stack<int>&r){
    if(N == 0)
        return;
        
    r.push(s.top());
    s.pop();
    reverseStack(s,N-1,r);
}
void insertStack(stack<int>&s,int a)
{
    if(s.size() == 0)
    {
        s.push(a);
        return;
    }
    
    int temp = s.top();
    s.pop();
    insertStack(s,a);
    s.push(temp);
}
void reverseStack(stack<int>&s){
    if(s.size() == 0)
        return ;
    int temp = s.top();
    s.pop();
    reverseStack(s);
    insertStack(s,temp);
}
int main()
{
    stack<int> s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    int N = s.size();
    printStack(s,N);
    cout<<endl;
    reverseStack(s);
    //stack<int>r;
    //reverseStack(s,N,r);
    //deleteMid(s,N);
    //cout<<"Size of " << s.size() <<endl;
    //N = s.size();
    printStack(s,N);
    return 0;
}
