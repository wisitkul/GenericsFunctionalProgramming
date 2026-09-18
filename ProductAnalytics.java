import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class ProductAnalytics {
    private List<Product> productCatalog;

    public ProductAnalytics(List<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    // TODO: Refactor เมธอดทั้งหมดด้านล่างนี้ให้ใช้ Stream API

    /**
     * ค้นหาสินค้าทั้งหมดในหมวดหมู่ที่กำหนด
     */
    public List<Product> findProductsByCategory(String category) {
        //List<Product> results = new ArrayList<>();
        //for (Product p : productCatalog) {
        //    if (p.category().equalsIgnoreCase(category)) {
        //        results.add(p);
        //    }
        //}
        //return results;
        return  productCatalog.stream()
        .filter(p -> p.category().equalsIgnoreCase(category))
        .collect(Collectors.toList()); 
    }

    /**
     * คืนค่า "ชื่อ" ของสินค้าทั้งหมดที่มีราคาต่ำกว่าที่กำหนด
     */
    public List<String> getProductNamesWithPriceLessThan(double maxPrice) {
        //List<String> results = new ArrayList<>();
        //for (Product p : productCatalog) {
        //    if (p.price() < maxPrice) {
        //        results.add(p.name());
        //    }
        //}
        //return results;
        return productCatalog.stream()
        .filter(p -> p.price() < maxPrice)
        .map(p -> p.name())
        .collect(Collectors.toList());
    }

    /**
     * คำนวณมูลค่ารวมของสต็อกสินค้าในหมวดหมู่ที่กำหนด
     */
    public double calculateTotalStockValueForCategory(String category) {
        //double totalValue = 0.0;
        //for (Product p : productCatalog) {
        //    if (p.category().equalsIgnoreCase(category)) {
        //        totalValue += p.price() * p.stock();
        //    }
        //}
        //return totalValue;
        return productCatalog.stream()
        .filter(p -> p.category().equalsIgnoreCase(category))
        .mapToDouble(p -> p.price() * p.stock())
        .sum();
    }

    /**
     * ตรวจสอบว่ามีสินค้าที่หมดสต็อก (stock = 0) หรือไม่
     */
    public boolean hasProductOutOfStock() {
        //for (Product p : productCatalog) {
        //    if (p.stock() == 0) {
        //        return true;
        //    }
        //}
        //return false;
        return productCatalog.stream()
        .filter(p->p.stock()==0)
        .count()>0;

        /*
        return productCatalog.stream()
        .anyMath(p->p.stock==0);
        */
    }
}
