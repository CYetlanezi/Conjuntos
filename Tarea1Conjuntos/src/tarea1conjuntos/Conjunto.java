package tarea1conjuntos;


public class Conjunto <T>{
         private String nombre;
         private int  max;
         protected int n;
         protected T conjunto[];

         public Conjunto(int max, String nombre) {
                  this.nombre = nombre;
                  this.max = max;
                  n = 0;
                  conjunto = (T[]) new Comparable[max];
         }
         
         public String toString() {
                  String cadena="";
                  for (int i = 0; i < n; i++)
                            cadena += "\n"+conjunto[i];
                  
                  return cadena;
         }
         
         public boolean AltaElemento(T obj){
                  boolean res;
                  if( n == max  )
                           res = false;
                  else{ 
                           conjunto[n] = obj;
                           n++;
                           res = true;
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
                  if (BusquedaSecuencial(obj) == -1) 
                           res =  false;
                  else  
                           res = true;
                  
                  return res;
         }
         
         public T getElemento(int i){
                  T res = conjunto[i];
                   return res;
         }
         
         public String getTipo(){
                  return ""+conjunto[0].getClass().getName();
         }
}
