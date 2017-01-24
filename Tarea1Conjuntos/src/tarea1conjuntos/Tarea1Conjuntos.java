package tarea1conjuntos;

import java.util.Scanner;

public class Tarea1Conjuntos<T,U> {
        static final  int max=30;
         static Conjunto<Integer> ConA;
         static Conjunto<Integer> ConB;
         static Integer[] Ca;
         static Integer[] Cb;
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
                                                               System.out.println("Cardinalidad :"+ConA.Cardinalida());
                                                     break;
                                                     case 2:
                                                               System.out.println("Cardinalida :"+ConB.n);
                                                     break;
                                                      default:
                                                               System.out.println("Opción no-válida");
                                             }
                                             break;
                                    default:
                                             System.out.println("Opción no-válida");
                           }
                           System.out.println("Nueva Opcion : ");
                           opcion = leer.nextInt();
                  }
         }
         
         public static void Alta(){
                  Ca = new Integer[max];
                  Ca[0]= 2;
                  Ca[1]= 13;
                  Ca[2]=7;
                  Ca[3]=11;
                  Ca[4]=3;
                  Ca[5]=23;
                  Ca[6]=31;
                  ConA = new Conjunto<Integer>(Ca,max,"Primos");
                  System.out.println("Conjunto "+ConA.getNombre()+"  "+ConA);
                  
                  Cb = new Integer[max];
                  Cb[0]= 2;
                  Cb[1]= 4;
                  Cb[2]=10;
                  Cb[3]=32;
                  Cb[4]=22;
                  Cb[5]=16;
                  ConB = new Conjunto<Integer>(Cb,max,"Pares");
                  System.out.println("Conjunto "+ConB.getNombre()+"  "+ConB);
         }
         

         
         public static void Union(Conjunto A, Conjunto B){
                  
                  Conjunto<Integer> Union = new Conjunto<>(max*2,"Union");
                  Conjunto<Integer> auxMenor = new Conjunto<>(max,"aux");  
                  Conjunto<Integer> auxMayor = new Conjunto<>(max,"aux");  
                  
                            int cardA = ((Conjunto)A).Cardinalida();
                            int cardB = ((Conjunto)A).Cardinalida();
                            
                            if (cardA    <   cardB){
                                    auxMenor = A;
                                    auxMayor = B;
                           }
                           else{
                                    auxMenor = B;
                                    auxMayor = A;
                           }
                           
                           for (int i = 0; i < auxMayor.Cardinalida() ; i++) 
                                             Union.AltaElemento((Integer) ((Conjunto)auxMayor).getElemento(i));
                           for (int i = 0; i < auxMenor.Cardinalida(); i++) 
                                    if(!((Conjunto)auxMayor).EsElemento(((Conjunto)auxMenor).getElemento(i)))
                                             Union.AltaElemento((Integer) ((Conjunto)auxMenor).getElemento(i));
//                           
                           System.out.println("La Union de "+((Conjunto)A).getNombre()+"  y  "+((Conjunto)B).getNombre()+" es :"+Union);
                 
         }
         
         public static void Interseccion(Conjunto A, Conjunto B){
                  Conjunto<Integer> Inter = new Conjunto<>(max,"Intersección");
                  Conjunto<Integer> auxMenor = new Conjunto<>(max,"aux");  
                  Conjunto<Integer> auxMayor = new Conjunto<>(max,"aux");  
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           int cardB = ((Conjunto)A).Cardinalida();
                           
                           if (cardA    <   cardB){
                                    auxMenor = A;
                                    auxMayor = B;
                           }
                           else{
                                    auxMenor = B;
                                    auxMayor = A;
                           }
                           
                           for (int i = 0; i < auxMenor.Cardinalida(); i++) 
                                    if(((Conjunto)auxMenor).EsElemento(((Conjunto)auxMayor).getElemento(i)))
                                             Inter.AltaElemento((Integer) ((Conjunto)auxMenor).getElemento(i));
                           
                           System.out.println("La Intersección  de "+((Conjunto)A).getNombre()+"  y  "+((Conjunto)B).getNombre()+" es :"+Inter);
         }
         
         public static void Resta(Conjunto A, Conjunto B){
                  Conjunto<Integer> Resta = new Conjunto<>(max,"Intersección");
                  
                           int cardA = ((Conjunto)A).Cardinalida();
                           for (int i = 0; i < cardA; i++) 
                                    if(!((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                             Resta.AltaElemento((Integer) ((Conjunto)A).getElemento(i));
                           
                           System.out.println("La Resta de "+((Conjunto)A).getNombre()+"  menos  "+((Conjunto)B).getNombre()+" es :"+Resta);
         }
         
         public static void RestaSimetrica(Conjunto A, Conjunto B){
                  Conjunto<Integer> RestaS = new Conjunto<>(max*2,"Intersección");
                           int cardA = ((Conjunto)A).Cardinalida();
                           int cardB = ((Conjunto)B).Cardinalida();
                           
                           for (int i = 0; i < cardA; i++) 
                                    if(!((Conjunto)B).EsElemento(((Conjunto)A).getElemento(i)))
                                             RestaS.AltaElemento((Integer) ((Conjunto)A).getElemento(i));
                           
                           for (int i = 0; i < cardB; i++) 
                                    if(!((Conjunto)A).EsElemento(((Conjunto)B).getElemento(i)))
                                             RestaS.AltaElemento((Integer) ((Conjunto)B).getElemento(i));
                                             
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
