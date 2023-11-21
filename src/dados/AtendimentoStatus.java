package dados;

public enum AtendimentoStatus {
    PEN ("PENDENTE"),
    EX ("EXECUTANDO"),
    FIN ("FINALIZADO"),
    CANCEL ("CANCELADO");

    private String status;

    private AtendimentoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    // Método para retornar o status do atendimento
    public static AtendimentoStatus getAtendimentoStatus(String status) {
        for (AtendimentoStatus a : AtendimentoStatus.values()) {
            if (a.getStatus().equals(status)) {
                return a;
            }
        }
        return null;
    }
}
