package oncall;

import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        OnCallConfig onCallConfig = new OnCallConfig();
        OnCallController onCallController = onCallConfig.onCallController();
        onCallController.process();
    }
}
