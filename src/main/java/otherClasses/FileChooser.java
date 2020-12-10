package otherClasses;

import java.awt.Container;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Vilrose Daquiado
 */

public class FileChooser extends JFileChooser {

    private int returnVal;
    //    private final JFileChooser jFileChooser;
    private File file;
    private final Container parent;

    public FileChooser(Container parent){
        // set the directory path to the current directory
        super(new java.io.File("../"));
        super.setDialogType(JFileChooser.CUSTOM_DIALOG);
        super.setFileFilter(new CustomFileFilter());
        super.setApproveButtonText("Importieren");
        super.setDragEnabled(true);

        this.parent = parent;
        returnVal = showOpenDialog(parent);


        init();


    }

    public final void init(){

        if(returnVal == JFileChooser.APPROVE_OPTION){
            /*save the file selected when Upload button was clicked*/
            file = this.getSelectedFile();
        }
    }

    public File getFile() {
        return file;
    }

    public int getReturnVal() {
        return returnVal;
    }
}
