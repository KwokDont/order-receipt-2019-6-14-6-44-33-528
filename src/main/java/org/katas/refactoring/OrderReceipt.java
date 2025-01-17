package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    private final double TAX_RATE_OF_10_PERCENT = 0.10d;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output = printHeaders(output)
                .append(printCustomerNameAndAddress(output))
                .append(printItemsWithTaxAndTotal(output));

        return output.toString();
    }

    StringBuilder printHeaders(StringBuilder output){
        return output.append("======Printing Orders======\n");
    }

    StringBuilder printCustomerNameAndAddress(StringBuilder output){
        output.append(order.getName());
        return output.append(order.getAddress());
    }

    StringBuilder printItemsWithTaxAndTotal(StringBuilder output){

        double totSalesTx = 0d;
        double total = 0d;

        for (LineItem lineItem : order.getItems()) {
            output = appendItemLine(output, lineItem);
            double salesTax = lineItem.totalAmount() * TAX_RATE_OF_10_PERCENT;
            totSalesTx += salesTax;
            total += lineItem.totalAmount() + salesTax;
        }
        output = printsSalesTax(output,totSalesTx)
                .append(printTotalAmount(output,total));
        return output;
    }

    StringBuilder appendItemLine(StringBuilder output, LineItem lineItem){
        output.append(lineItem.getDesc());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
        return output;
    }

    StringBuilder printsSalesTax(StringBuilder output, double totSalesTx){
        return output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    StringBuilder printTotalAmount(StringBuilder output, double total){
        return output.append("Total Amount").append('\t').append(total);
    }
}