package validation;

/**
 *A record to store valid financial statments with its own date, category, and amount fields
 *
 * @author David Guanga
 * @author Selina Zhu
 * @author Tasfia Rahman
 * 
 * */
public record FinanceDataEntry(String date, String category, int amount)
{
}
