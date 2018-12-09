package com.example.geo.museumguide.connection.artefact;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.geo.museumguide.connection.user.LogInService;
import com.example.geo.museumguide.constante.RESTConst;
import com.example.geo.museumguide.model.User;
import com.example.geo.museumguide.tour.ArtefactBean;
import com.example.geo.museumguide.tour.NFCTourActivity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Geo on 1/28/2017.
 */

public class GetArtifactByIdAndShowTask extends AsyncTask<Object, Void, ArtefactBean> {

    private Activity source;

    public GetArtifactByIdAndShowTask(Activity source) {
        this.source = source;
    }

    public GetArtifactByIdAndShowTask(){

    }

    @Override
    protected ArtefactBean doInBackground(Object... params) {
        Long id = (Long) params[0];
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", Arrays.asList(LogInService.getLoggedUser().getToken()));
            HttpEntity<User> entity = new HttpEntity<User>(headers);

            String uri = RESTConst.getByIdPath(RESTConst.ARTEFACT_REST_PATH, id);

            ResponseEntity<ArtefactBean> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ArtefactBean.class);

            return result.getBody();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArtefactBean artefact) {
        if(artefact==null){
            Toast.makeText(source, "Artifact not found, please try again!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(source, "Artifact found!", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(source, NFCTourActivity.class);
        intent.putExtra("artefact", artefact);
        source.startActivity(intent);
    }

  /*  protected void showCustomDialog(ArtefactBean artefact1) {
        final Dialog dialog = new Dialog(source);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.nfc_tour_layout);

        TextToSpeech t1;
        ImageButton playBtn = (ImageButton) dialog.findViewById(R.id.imageButtonCancel);
        ImageButton pauseBtn = (ImageButton) dialog.findViewById(R.id.imageButtonCancel);
        ImageButton cancelBtn = (ImageButton) dialog.findViewById(R.id.cancelBtnNfc);

        TextView title = (TextView) dialog.findViewById(R.id.nameDepText);
        TextView author = (TextView) dialog.findViewById(R.id.beaconIDtxt);
        TextView year = (TextView) dialog.findViewById(R.id.detailsDep1Text);
        TextView description = (TextView) dialog.findViewById(R.id.detailsDep1Text);
        title.setText(artefact1.getTitle());
        author.setText(artefact1.getAuthor());
        year.setText(String.valueOf(artefact1.getYear()));
        description.setText(artefact1.getDescription());
        cancelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    */
}
