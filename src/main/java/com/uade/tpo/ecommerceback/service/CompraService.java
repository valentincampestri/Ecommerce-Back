package com.uade.tpo.ecommerceback.service;

import com.uade.tpo.ecommerceback.controllers.shoppingCart.CompraRequest;
import com.uade.tpo.ecommerceback.entity.Compra;
import com.uade.tpo.ecommerceback.entity.Producto;
import com.uade.tpo.ecommerceback.repository.ICompraRepository;
import com.uade.tpo.ecommerceback.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CompraService implements ICompraService {
    @Autowired
    private ICompraRepository compraRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public Compra GuardarCompra(CompraRequest compra) {
        Compra compraSave = new Compra();
        List<Producto> productoList = new ArrayList<>();
        double montoTotal = 0;
        for (Long id : compra.getIdProductos()){
            productoList.add(productoRepository.findById(id).get());
        }
        for (Producto producto : productoList){
            producto.setStock(producto.getStock() - 1);
            productoRepository.save(producto);
            montoTotal += producto.getPrecio();
        }
        compraSave.setFecha(LocalDate.now());
        compraSave.setMonto(montoTotal);
        return compraRepository.save(compraSave);
    }
}
