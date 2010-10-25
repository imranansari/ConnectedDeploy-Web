
/**
 * Created by IntelliJ IDEA.
 * User: imranansari
 * Date: 10/24/10
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
class DeviceUtil {

 public boolean doSendViaC2dm(String url, String title, String sel, Object push,
            String collapseKey, DeviceInfo deviceInfo) throws IOException {

        // Trim title, sel if needed.
        if (url.length() + title.length() + sel.length() > 1000) {
            // Shorten the title - C2DM has a 1024 limit, some padding for keys
            if (title.length() > 16) {
                title = title.substring(0, 16);
            }
            // still not enough ?
            if (title.length() + url.length() + sel.length() > 1000) {
                // how much space we have for sel ?
                int space = 1000 - url.length() - title.length();
                if (space > 0 && sel.length() > space) {
                    sel = sel.substring(0, space);
                } // else: we'll get an error sending
            }
            // TODO: when we have history, save the url/title/sel in the history
            // and send a pointer, have device fetch it.
        }

        boolean res;
        res = push.sendNoRetry(deviceInfo.getDeviceRegistrationID(),
                collapseKey,
                "url", url,
                "title", title,
                "sel", sel,
                "debug", deviceInfo.getDebug() ? "1" : null);
        return res;
    }

}
