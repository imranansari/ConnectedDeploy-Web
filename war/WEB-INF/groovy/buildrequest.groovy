log.info "build request invoked"

import com.google.appengine.api.datastore.Query
import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit
import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import org.codehaus.jackson.map.ObjectMapper



DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
ArrayList responsePojos = new ArrayList();

def query = new Query("build_request")
query.addSort("date", Query.SortDirection.DESCENDING)
def preparedQuery = datastore.prepare(query)
def buildRequests = preparedQuery.asList(withLimit(10))

def ct = preparedQuery.countEntities();
log.info "count :"+ ct;

//def jsonString = buildRequests.get(1) as JSONObject

//log.info jsonString


buildRequests.each{
  responsePojos.add(it as BuildRequest);
}

response.contentType = "application/json"

ObjectMapper mapper = new ObjectMapper();
mapper.writeValue(out, responsePojos);