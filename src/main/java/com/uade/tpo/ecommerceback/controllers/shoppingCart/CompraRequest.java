package com.uade.tpo.ecommerceback.controllers.shoppingCart;

import com.uade.tpo.ecommerceback.controllers.product.ProductoCantidadRequest;

import java.util.List;

public class CompraRequest {
    private List<ProductoCantidadRequest> productoCantidadRequests;
    private int idUser;

    public List<ProductoCantidadRequest> getProductoCantidadRequests() {
        return productoCantidadRequests;
    }

    public void setProductoCantidadRequests(List<ProductoCantidadRequest> productoCantidadRequests) {
        this.productoCantidadRequests = productoCantidadRequests;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getCantidadById(Long idProducto) {
        for (ProductoCantidadRequest productoCantidad : productoCantidadRequests) {
            if (productoCantidad.getIdProducto().equals(idProducto)) {
                return productoCantidad.getCantidad();
            }
        }
        return 0;
    }
}
