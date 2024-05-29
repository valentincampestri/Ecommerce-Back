package com.uade.tpo.ecommerceback.controllers.shoppingCart;

import com.uade.tpo.ecommerceback.entity.Compra;
import com.uade.tpo.ecommerceback.entity.Producto;
import com.uade.tpo.ecommerceback.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("ShoppingCart")
public class ShoppingCartController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/Crear")
    public ResponseEntity<Compra> createCompra(@RequestBody CompraRequest compraRequest){
        Compra compra  = compraService.GuardarCompra(compraRequest);
        return ResponseEntity.created(URI.create("/ShoppingCart/"+compra.getId())).body(compra);
    }

}
