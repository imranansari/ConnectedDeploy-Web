log.info "device registration"


String deviceRegistrationId = request.getParameter("devregid");

String deviceName = request.getParameter("deviceName");
if (deviceName == null) {
  deviceName = "Phone";
}

String deviceType = request.getParameter("deviceType");
if (deviceType == null) {
  deviceType = "ac2dm";
}

// Because the deviceRegistrationId isn't static, we use a static
// identifier for the device. (Can be null in older clients)
String deviceId = request.getParameter("deviceId");

log.info("deviceName = " + deviceName);
log.info("deviceType = " + deviceType);
log.info("deviceId = " + deviceId);
log.info("deviceRegistrationId = " + deviceRegistrationId);


/*DeviceUtil deviceUtil = new DeviceUtil();
C2DMessaging push = C2DMessaging.get(getServletContext());

DeviceInfo deviceInfo = new DeviceInfo();
deviceInfo.setDeviceRegistrationID(deviceRegistrationID);

deviceUtil.doSendViaC2dm("http://www.cnn.com", "cnn", "", push,
            "cd", deviceInfo)*/



