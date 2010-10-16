import com.twilio.sdk.TwilioRestClient
import com.twilio.sdk.TwilioRestException
import com.twilio.sdk.TwilioRestResponse

/**
 * Created by IntelliJ IDEA.
 * User: imranansari
 * Date: Oct 15, 2010
 * Time: 4:50:36 PM
 * To change this template use File | Settings | File Templates.
 */
class OutgoingCall {

  /* Twilio REST API version */
  public static final String APIVERSION = "2010-04-01";

  void callContact(String projectName) {
    TwilioRestClient twilioRestClient = new TwilioRestClient("AC105c4227d7c4c2159940a045d8729f59", "733b8204bf626cb60a04656b3ea4629b", null);
    makeCallExample(twilioRestClient, "+19192465059", "+18323268664", "http://connecteddeploy.appspot.com/buildrequestphone?projectName="+projectName)
  }

      private static void makeCallExample(TwilioRestClient client, String from, String to, String url ){

        //build map of post parameters
        Map<String,String> params = new HashMap<String,String>();
        params.put("From", from);
        params.put("To", to);
        params.put("Url", url);
        TwilioRestResponse response;
        try {
            response = client.request("/"+APIVERSION+"/Accounts/"+client.getAccountSid()+"/Calls", "POST", params);

            if(response.isError())
                System.out.println("Error making outgoing call: "+response.getHttpStatus()+"\n"+response.getResponseText());
            else {
                System.out.println(response.getResponseText());

            }
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
    }

}
