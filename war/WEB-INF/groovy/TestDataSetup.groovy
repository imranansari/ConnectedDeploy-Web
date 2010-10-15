import com.google.appengine.api.datastore.Entity
/**
 * Created by IntelliJ IDEA.
 * User: imranansari
 * Date: Oct 10, 2010
 * Time: 9:21:34 PM
 * To change this template use File | Settings | File Templates.
 */

def buildRequest = new Entity("build_request")
buildRequest.projectName = "hibernate"
buildRequest.status = "success";
buildRequest.date = new Date();

log.info "build request created"

buildRequest.save()