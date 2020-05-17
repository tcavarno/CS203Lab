

public abstract class BinaryExpression{
    private final Expression lft;
    private final Expression rht;
    private final String opperator;
    public BinaryExpression(final Expression lft, final Expression rht, String opperator)
    {
      this.lft = lft;
      this.rht = rht;
      this.opperator = opperator;
    }
    public Expression getLft(){return this.lft;}
    public Expression getRht(){return this.rht;}

    public String toString()
    {
      return "(" + lft + " " + opperator + " " + rht + ")";
    }
    public double evaluate(final Bindings bindings)
    {
       return this._applyOperator(this.lft.evaluate(bindings) ,this.rht.evaluate(bindings));
    }
  
    protected abstract double _applyOperator(double lft,double rht);


}