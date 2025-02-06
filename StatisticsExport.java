import java.io.PrintWriter;
import java.util.*;
import java.util.stream.*;

public class StatisticsExport {
    private List<Sale> sales;

    public StatisticsExport(List<Sale> sales) {
        this.sales = sales;
    }

    public void exportStatistics() {
        try (PrintWriter writer = new PrintWriter("sales_statistics.txt")) {
            writer.println("=== SALES STATISTICS ===");

            Map<Product, Long> salesByProduct = sales.stream()
                    .collect(Collectors.groupingBy(Sale::getProduct, Collectors.counting()));

            Map<Product, Double> revenueByProduct = sales.stream()
                    .collect(Collectors.groupingBy(
                            Sale::getProduct,
                            Collectors.summingDouble(Sale::getTotalPrice)
                    ));

            writer.println("\n--- Sales by Product ---");
            salesByProduct.forEach((product, quantity) -> {
                writer.printf("%s: %d units, Revenue: €%.2f\n",
                        product.getName(), quantity, revenueByProduct.get(product));
            });

            Product bestSellingProduct = salesByProduct.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            double totalRevenue = revenueByProduct.values().stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();

            writer.println("\n=== SUMMARY ===");
            writer.println("Best-selling product: " +
                    (bestSellingProduct != null ? bestSellingProduct.getName() : "N/A"));
            writer.printf("Total Revenue: €%.2f\n", totalRevenue);

            System.out.println("✅ Statistics exported to sales_statistics.txt");
        } catch (Exception e) {
            System.err.println("❌ Export error: " + e.getMessage());
        }
    }
}