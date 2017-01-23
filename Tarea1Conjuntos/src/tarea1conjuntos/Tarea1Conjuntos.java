package tarea1conjuntos;

import java.util.Scanner;

public class Tarea1Conjuntos<T,U> {
         static Conjunto<Integer> ConA;
         static Conjunto<Integer> ConB;
         static Scanner leer = new Scanner(System.in);
         
         public static void main(String[] args) {
                  Inicio();
         }
         
         public static void Inicio(){
                  
                  int opcion;
                  System.out.println("\t\t**Conjuntos**\n");
                  System.out.println("\tSelecciona una opción");
                  System.out.println("\t 1. Alta");
                  System.out.println("\t 2. Unión");
                  System.out.println("\t 3. Intersección");
                  System.out.println("\t 4. Resta");
                  System.out.println("\t 5. Resta Simétrica");
                  System.out.println("\t 6. Es Elemento");
                  System.out.println("\t 7. Regresa Elemento");
                  System.out.println("\t 8. Cardinalidad");
                  System.out.println("\t 9. Salir\n");
                  opcion = leer.nextInt();
                  int con;
                  
                  while(opcion != 9){
                           switch(opcion){
                                    case 1:
                                              Alta();
                                              break;
                                    case 2:
                                              Union(ConA,ConB);
                                              break;
                                    case 3:
                                              Interseccion(ConA,ConB);
                                              break;
                                    case 4:
                                              Resta(ConA,ConB);
                                              break;
                                    case 5:
                                              RestaSimetrica(ConA,ConB);
                                              break;
                                    case 6:
                                             System.out.println("Selecione un conjunto:");
                                             System.out.println("\t\t1. "+ConA.getNombre());
                                             System.out.println("\t\t2. "+ConB.getNombre());
                                             con = leer.nextInt();
                                             switch (con) {
                                                      case 1:
                                                               EsElemento(ConA);
                                                     break;
                                                     case 2:
                                                               EsElemento(ConB);
                                                     break;
                                                      default:
                                                               System.out.println("Opción no-válida");
                                             }
                                             break;
                                    case 7:
                                             System.out.println("Selecione un conjunto:");
                                             System.out.println("\t\t1. "+ConA.getNombre());
                                             System.out.println("\t\t2. "+ConB.getNombre());
                                             con = leer.nextInt();
                                             switch (con) {
                                                      case 1:
                                                               getElemento(ConA);
                                                     break;
                                                     case 2:
                                                               getElemento(ConB);
                                                     break;
                                                      default:
                                                               System.out.println("Opción no-válida");
                                             }
                                             break;
                                    case 8:
                                            System.out.println("Selecione un conjunto:");
                                             System.out.println("\t\t1. "+ConA.getNombre());
                                             System.out.println("\t\t2. "+ConB.getNombre());
                                             con = leer.nextInt();
                                             switch (con) {
                                                      case 1:
                                                               System.out.println("Cardinalidad :"+ConA.n);
                                                     break;
                                                     case 2:
                                                               System.out.println("Cardinalida :"+ConB.n);
                                                     break;
                                                      default:
                                                               System.out.println("Opción no-válida");
                                             }
                                             break;
                                    case 9:
                                             System.exit(0);
                                             break;
                                    default:
                                             System.out.println("Opción no-válida");
                           }
                           System.out.println("Nueva Opcion : ");
                           opcion = leer.nextInt();
                  }
         }
         
         public static void Alta(){
                  ConA = new Conjunto<Integer>(30,"Primos");
                           ConA.AltaElemento(2);
                           ConA.AltaElemento(13);
                           ConA.AltaElemento(7);
                           ConA.AltaElemento(11);
                           ConA.AltaElemento(3);
                           ConA.AltaElemento(23);
                           ConA.AltaElemento(31);
                  System.out.println("Conjunto "+ConA.getNombre()+"  "+ConA);
                  
                  ConB = new Conjunto<Integer>(30,"Pares");  
                           ConB.AltaElemento(2);
                           ConB.AltaElemento(4);
                           ConB.AltaElemento(10);
                           ConB.AltaElemento(32);
                           ConB.AltaElemento(22);
                           ConB.AltaElemento(16);
                  System.out.println("Conjunto "+ConB.getNombre()+"  "+ConB);
         }
         
//         public static boolean MismoTipo(Conjunto A, Conjunto B){
//                  boolean res;
//                  if(A.getClass().equals(B))
//                           res = true;
//                  else
//                      res = false;
//                  
//                  return res;
//         }
         
         public static void Union(Conjunto A, Conjunto B){
                  String Union="";
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           int cardB = ((Conjunto)B).Cardinalida();
                           for (int i = 0; i < cardA; i++) 
                                             Union += "\n"+ ((Conjunto)A).getElemento(i);
                           for (int i = 0; i < cardB; i++) 
                                    if(!((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                             Union += "\n"+ ((Conjunto)B).getElemento(i);
                           
                           System.out.println("La Union de "+((Conjunto)A).getNombre()+"  y  "+((Conjunto)B).getNombre()+" es :"+Union);
                 
         }
         
         public static void Interseccion(Conjunto A, Conjunto B){
                  String Inter="";
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           for (int i = 0; i < cardA; i++) {
                                    if(((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                              Inter += "\n"+ ((Conjunto)A).getElemento(i);
                           }
                           System.out.println("La Intersección  de "+((Conjunto)A).getNombre()+"  y  "+((Conjunto)B).getNombre()+" es :"+Inter);
                  
         }
         
         public static void Resta(Conjunto A, Conjunto B){
                  String Resta="";
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           for (int i = 0; i < cardA; i++) 
                                    if(!((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                             Resta += "\n"+ ((Conjunto)A).getElemento(i);
                           
                           System.out.println("La Resta de "+((Conjunto)A).getNombre()+"  menos  "+((Conjunto)B).getNombre()+" es :"+Resta);
                  
         }
         
         public static void RestaSimetrica(Conjunto A, Conjunto B){
                  String RestaS="";
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           int cardB = ((Conjunto)B).Cardinalida();
                           for (int i = 0; i < cardA; i++) 
                                    if(!((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                             RestaS += "\n"+ ((Conjunto)A).getElemento(i);
                           
                           for (int i = 0; i < cardB; i++) 
                                    if(!((Conjunto)A).EsElemento(((Conjunto)B).getElemento(i)))
                                             RestaS += "\n"+ ((Conjunto)B).getElemento(i);
                                             
                           System.out.println("La Resta Simétrica de "+((Conjunto)A).getNombre()+"  y  "+((Conjunto)B).getNombre()+" es :"+RestaS);
                  
         }
         
         public static void EsElemento(Conjunto S){
                  Conjunto<Integer>  aux = new Conjunto<Integer>(1,"");
                  
                  System.out.println("Elemento a buscar en "+S.getNombre());
                  aux.AltaElemento(leer.nextInt());
                  if(((Conjunto)S).EsElemento(((Conjunto)aux).getElemento(0)))
                           System.out.println("Sí es elemento");
                  else
                           System.out.println("No es elemento");
         }
         
         public static void getElemento(Conjunto S){
                  Conjunto<Integer>  aux = new Conjunto<Integer>(1,"");
                  
                  System.out.println("Elemento a buscar en "+S.getNombre());
                  aux.AltaElemento(leer.nextInt());
                  if(((Conjunto)S).EsElemento(((Conjunto)aux).getElemento(0)))
                           System.out.println("Sí es elemento "+((Conjunto)aux).getElemento(0));
                  else
                           System.out.println("No es elemento");
         }
}
