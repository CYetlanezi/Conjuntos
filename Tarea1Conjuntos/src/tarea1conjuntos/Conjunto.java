package tarea1conjuntos;


public class Conjunto <T>{
         private String nombre;
         private int  dim;
         protected int n;
         protected T conjunto[];

         public Conjunto(int dim,String nombre) {
                  this.nombre = nombre;
                  this.dim = dim;
                  n = 0;
                  conjunto = (T[]) new Comparable[dim];
         }
         
         public Conjunto(T conjunto[],int dim,String nombre){
                  this.nombre = nombre;
                  this.dim = dim;
                  this.conjunto = (T[]) new Comparable[dim];
                  
                  for (int i = 0; i < dim; i++){ 
                           this.conjunto[i] = conjunto[i];
                           if (this.conjunto[i] != null) 
                                    n++;
                  }
         }
         
         public String toString() {
                  String cadena="";
                  for (int i = 0; i < n; i++)
                            cadena += "\n"+conjunto[i];
                  
                  return cadena;
         }
         
         public boolean AltaElemento(T obj){
                  
                  boolean res;
                  if( n ==0 || BusquedaSecuencial(obj)   <  0  ){
                           conjunto[n] = obj;
                           n++;
                           res = true;
                   }
                  else{ 
                           res = false;
                  }
                  return res;          
         }
         
         public int BusquedaSecuencial(T obj){
                  int i=0;
                  while(!conjunto[i].equals(obj)    &&  i<n-1)
                           i++;
                  if(!conjunto[i].equals(obj))
                           i = -1;
                  
                  return i;
         }
         
         public int Cardinalida(){
                  return n;
         }
         
         public String getNombre(){
                  return nombre;
         }
         
         public boolean EsElemento(T obj){
                  boolean res;
                  if (BusquedaSecuencial(obj) < 0) 
                           res =  false;
                  else  
                           res = true;
                  
                  return res;
         }
         
         public T getElemento(int i){
                  T res = conjunto[i];
                   return res;
         }
         
}
