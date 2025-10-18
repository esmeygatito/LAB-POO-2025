/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package animales;

/**
 *
 * @author esmeg
 */
public interface IAcuatico {
    
    void nadar();
    
    default int profundidadMax(){
        return 200;
    }
    
    
}


