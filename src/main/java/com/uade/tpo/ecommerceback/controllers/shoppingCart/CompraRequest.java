package com.uade.tpo.ecommerceback.controllers.shoppingCart;

import java.util.List;

public class CompraRequest {
    private List<Long> idProductos;
    private int idUser;

    public List<Long> getIdProductos() {
        return idProductos;
    }

    public int getIdUser() {
        return idUser;
    }
}
