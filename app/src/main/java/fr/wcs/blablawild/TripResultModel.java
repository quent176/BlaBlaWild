package fr.wcs.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 12/09/17.
 */

public class TripResultModel {
    private String nomConducteur;
    private Date dateTransport;
    private int prixTransport;

    public TripResultModel(String nameDriver, Date dateTransport, Integer prixTransport) {
        this.nomConducteur = nameDriver;
        this.dateTransport = dateTransport;
        this.prixTransport = prixTransport;
    }

    public String getNameDriver() {
        return this.nomConducteur;
    }

    public Date getDateTransport() {
        return dateTransport;
    }

    public int getPriceTransport() {
        return prixTransport;
    }

}

