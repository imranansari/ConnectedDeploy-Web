import com.google.appengine.api.datastore.*

def messageRecieved = "Received message from ${message.from} with body ${message.body}"

log.info messageRecieved

//command
//build(cmd) hibernate(project) now(optional urgency)
//lastbuild(cmd) hibernate(project)

String recipient = message.from
def cmd = message.body.split(" ");

// check if the user is online
if (xmpp.getPresence(recipient).isAvailable()) {

  if ("build".equalsIgnoreCase(cmd[0].trim())) {
    def buildRequest = new Entity("build_request")
    buildRequest.projectName = cmd[1]
    buildRequest.status = "requested";
    buildRequest.date = new Date();

    buildRequest.save()
    log.info "build request created"
  }

  def status = xmpp.send(to: recipient, body: "your build request for " + cmd[1] + " was accepted")
  assert status.isSuccessful()

}