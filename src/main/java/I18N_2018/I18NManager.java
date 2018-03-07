package I18N_2018;

import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {

    private static I18NManager Instance;

    private HashMap <String, ResourceBundle> data;


    private I18NManager(){

        data = new HashMap<String, ResourceBundle>();
    }

    public static I18NManager getInstance(){
        if (Instance==null) Instance= new I18NManager();
        return Instance;

    }

    public String getText (String language, String key){

        ResourceBundle rb = data.get(language);
        if (rb==null) {
            rb = ResourceBundle.getBundle("I18N_2018.Resources");
            data.put(language,rb);

        }
        return rb.getString(key);
    }

    public static void main (String[] args){
        String value = I18NManager.getInstance().getText("ca","t1");
        value = I18NManager.getInstance().getText("ca","t2");
        value = I18NManager.getInstance().getText("en","t1");

    }

}
