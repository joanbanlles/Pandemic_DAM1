public class parametros {
    int numCiudadesInfectadasInicio;
    int numCuidadesInfectadasRonda;
    int numEnfermedadesActivasDerrota;
    int numBrotesDerrota;

    //hacer constructor
    public parametros(int numCiudadesInfectadasInicio, int numCuidadesInfectadasRonda, int numEnfermedadesActivasDerrota, int numBrotesDerrota) {
        this.numCiudadesInfectadasInicio = numCiudadesInfectadasInicio;
        this.numCuidadesInfectadasRonda = numCuidadesInfectadasRonda;
        this.numEnfermedadesActivasDerrota = numEnfermedadesActivasDerrota;
        this.numBrotesDerrota = numBrotesDerrota;

    }
    //getters y setters
    public int getNumCiudadesInfectadasInicio() {
        return numCiudadesInfectadasInicio;
    }
    public void setNumCiudadesInfectadasInicio(int numCiudadesInfectadasInicio) {
        this.numCiudadesInfectadasInicio = numCiudadesInfectadasInicio;
    }
    public int getNumCuidadesInfectadasRonda() {
        return numCuidadesInfectadasRonda;
    }
    public void setNumCuidadesInfectadasRonda(int numCuidadesInfectadasRonda) {
        this.numCuidadesInfectadasRonda = numCuidadesInfectadasRonda;
    }
    public int getNumEnfermedadesActivasDerrota() {
        return numEnfermedadesActivasDerrota;
    }
    public void setNumEnfermedadesActivasDerrota(int numEnfermedadesActivasDerrota) {
        this.numEnfermedadesActivasDerrota = numEnfermedadesActivasDerrota;
    }
    public int getNumBrotesDerrota() {
        return numBrotesDerrota;
    }
    public void setNumBrotesDerrota(int numBrotesDerrota) {
        this.numBrotesDerrota = numBrotesDerrota;
    }
}
