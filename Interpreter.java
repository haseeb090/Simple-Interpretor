package lab9ap;

import java.util.*;
import java.io.*;


/**
 *
 * @author Haseeb Khizar
 */
public class Lab9AP {

    public String[] s;
    public int value;
    
    public static void main(String[] args) {
        
        //FileReader in = null;
        Lab9AP l = new Lab9AP();
        try{
        //in = new FileReader("code.txt");
        Scanner scanner = new Scanner( new File("code.txt"), "UTF-8" );
        Map<String, Integer> m = new HashMap();
        String codeLine="";
        while (scanner.hasNextLine()){
            codeLine= scanner.nextLine();
            l.s = codeLine.split("\\s");
            if (l.s[0].equals("Let")){
                if (l.s[2].equals("=")){
                m.put(l.s[1], Integer.parseInt(l.s[3]));
                }
                else if ( l.s[2].equals(";"))
                {m.put(l.s[1], 0);}
                else {System.out.println("Incorrect Syntax");}
            }else if(m.containsKey(l.s[0])){
                int result;
                if (l.s[1].equals("=")){
                    if(m.containsKey(l.s[2])){
                        if(l.s[3].equals("+")){
                            int a = m.get(l.s[2]);
                            if(m.containsKey(l.s[4])){
                               int b = m.get(l.s[4]);
                               result = a+b;
                            } else {
                                int b = Integer.parseInt(l.s[4]);
                                result = a+b;
                            }
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("*")){
                            int a = m.get(l.s[2]);
                            if(m.containsKey(l.s[4])){
                               int b = m.get(l.s[4]);
                               result = a*b;
                            } else {
                                int b = Integer.parseInt(l.s[4]);
                                result = a*b;
                            }
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("/")){
                            int a = m.get(l.s[2]);
                            if(m.containsKey(l.s[4])){
                               int b = m.get(l.s[4]);
                               result = a/b;
                            } else {
                                int b = Integer.parseInt(l.s[4]);
                                result = a/b;
                            }
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("-")){
                            int a = m.get(l.s[2]);
                            if(m.containsKey(l.s[4])){
                               int b = m.get(l.s[4]);
                               result = a-b;
                            } else {
                                int b = Integer.parseInt(l.s[4]);
                                result = a-b;
                            }
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                    } else if(m.containsKey(l.s[4])){
                        if(l.s[3].equals("+")){
                            int a = m.get(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a+b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("*")){
                            int a = m.get(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a*b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("/")){
                            int a = m.get(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a/b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("-")){
                            int a = m.get(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a-b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                    }
                    else{
                        if(l.s[3].equals("+")){
                            int a = Integer.parseInt(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a+b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("*")){
                            int a = Integer.parseInt(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a*b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("/")){
                            int a = Integer.parseInt(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a+b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                        if(l.s[3].equals("-")){
                            int a = Integer.parseInt(l.s[4]);
                            int b = Integer.parseInt(l.s[2]);
                            result = a+b;
                            m.remove(l.s[0]);
                            m.put(l.s[0], result);
                        }
                    }
                }
            
            }else if (l.s[0].equals("Print")){
                String var = l.s[1].replace("[", "");
                var = var.replace("]", "");
                System.out.println(m.get(var));
            }
            
        }
        
        } catch(FileNotFoundException e){
            System.out.println(e.getClass());
        }
        
        // TODO code application logic here
    }
    
}
