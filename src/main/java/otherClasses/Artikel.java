package otherClasses;

import java.awt.List;
import java.util.*;
/**
 *
 * @author Vilrose Daquiado
 */

public class Artikel extends List {

    private final Map<String, String> rowMap;
    private String Hauptartikelnr, ArtikelName, Hersteller
            , Beschreibung, Materialangaben, Geschlecht, Produktart, Ärmel
            , Bein, Kragen, Herstellung, Taschenart, Grammatur, Material, Ursprungsland, Bildname;

    public Artikel( Map<String, String> rowMap) {

        this.rowMap = rowMap;

        this.Hauptartikelnr = rowMap.get("Hauptartikelnr").replace(".", "");
        this.ArtikelName = rowMap.get("ArtikelName");
        this.Hersteller = rowMap.get("Hersteller");
        this.Beschreibung = rowMap.get("Beschreibung");
        this.Materialangaben = rowMap.get("Materialangaben");
        this.Geschlecht     = rowMap.get("Geschlecht");
        this.Produktart = rowMap.get("Produktart");
        this.Ärmel  = rowMap.get("Ärmel");
        this.Bein   = rowMap.get("Bein");
        this.Kragen = rowMap.get("Kragen");
        this.Herstellung    = rowMap.get("Herstellung");
        this.Taschenart = rowMap.get("Taschenart");
        this.Grammatur  = rowMap.get("Grammatur");
        this.Material   = rowMap.get("Material");
        this.Ursprungsland  = rowMap.get("Ursprungsland");
        this.Bildname   = rowMap.get("Bildname").replace("[.]{0,1}", "");

    }


    @Override
    public String toString() {
        return "Hauptartikelnr: " + Hauptartikelnr.replace(".{1}", "") + "ArtikelName: "+ ArtikelName
                + "Hersteller: " + Hersteller+ "Beschreibung: " + Beschreibung + "Materialangaben: " + Materialangaben
                + "Geschlecht: " + Geschlecht+ "Produktart: " + Produktart+ "Ärmel: " + Ärmel
                + "Bein: " + Bein+ "Kragen: " + Kragen + "Herstellung: " + Herstellung + "Taschenart: " + Taschenart+ "Grammatur: " + Grammatur
                + "Material: " + Material+ "Ursprungsland: " + Ursprungsland + "Bildname: " + Bildname.replace("[.]{1}", "");
    }
    public String[] toArray(){
        return new String[]{Hauptartikelnr.replace(".{1}", ""),ArtikelName,Hersteller,Beschreibung
                ,Materialangaben, Geschlecht, Produktart, Ärmel,Bein
                , Kragen, Herstellung, Taschenart, Grammatur, Material, Ursprungsland, Bildname.replace(".{1}", "")};
    }
    public Map<String, String> toMap(){
        return Collections.unmodifiableMap(rowMap);
    }
}