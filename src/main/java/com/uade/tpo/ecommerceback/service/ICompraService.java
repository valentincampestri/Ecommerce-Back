package com.uade.tpo.ecommerceback.service;

import com.uade.tpo.ecommerceback.controllers.shoppingCart.CompraRequest;
import com.uade.tpo.ecommerceback.entity.Compra;

public interface ICompraService {
    Compra GuardarCompra(CompraRequest compra);
}
