public class Horario {

    private String hora;
    private double valor;

    public Horario(String hora, double valor){
        if (valor < 0){
            throw new IllegalArgumentException("valor esta negativo ");
            }
        this.hora = hora;
        this.valor = valor;
        }
        public String getHora(){
        return hora;
        }
        public double getValor(){
        return valor;
        }
}
