package grupo3p.auditorioproyect.entities.dto;

public class ReportStatus {

    private Integer completed;
    private Integer cancelled;

    public ReportStatus(int completed, int cancelled){
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
