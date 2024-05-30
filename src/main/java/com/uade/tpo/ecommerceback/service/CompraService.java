package com.uade.tpo.ecommerceback.service;

import com.uade.tpo.ecommerceback.controllers.product.ProductoCantidadRequest;
import com.uade.tpo.ecommerceback.controllers.product.ProductoRequest;
import com.uade.tpo.ecommerceback.controllers.shoppingCart.CompraRequest;
import com.uade.tpo.ecommerceback.entity.Compra;
import com.uade.tpo.ecommerceback.entity.ItemCompra;
import com.uade.tpo.ecommerceback.entity.Producto;
import com.uade.tpo.ecommerceback.repository.ICompraRepository;
import com.uade.tpo.ecommerceback.repository.IItemCompraRepository;
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
    @Autowired
    private IItemCompraRepository compraItemRepository;
    @Override
    public Compra GuardarCompra(CompraRequest compraRequest ) {
        Compra compraSave = new Compra();
        List<Producto> productoList = new ArrayList<>();
        double montoTotal = 0;
        for (ProductoCantidadRequest productoCantidadRequest : compraRequest.getProductoCantidadRequests()){
            Producto producto =  productoRepository.findById(productoCantidadRequest.getIdProducto()).get();
            producto.setStock(producto.getStock() - productoCantidadRequest.getCantidad());
            productoRepository.save(producto);
            montoTotal += producto.getPrecio();
            productoList.add(producto);
        }
        compraSave.setFecha(LocalDate.now());
        compraSave.setMonto(montoTotal);
        compraSave = compraRepository.save(compraSave);

        for(Producto producto: productoList){
            int cantidad = compraRequest.getCantidadById(producto.getId());
            ItemCompra itemCompra = new ItemCompra();
            itemCompra.setProducto(producto);
            itemCompra.setCantidad(cantidad);
            itemCompra.setPrecioUnitario(producto.getPrecio() * cantidad);
            itemCompra.setCompra(compraSave);
            compraItemRepository.save(itemCompra);
        }

        return compraSave;
    }
}
