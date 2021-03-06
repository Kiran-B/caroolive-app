/*
 * Copyright (c) 2014. Pokevian Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pokevian.app.smartfleet.request;

import com.android.volley.Response;
import com.pokevian.app.smartfleet.model.Rank;
import com.pokevian.app.smartfleet.setting.ServerUrl;
import com.pokevian.app.smartfleet.volley.GsonRequest;
import com.pokevian.app.smartfleet.volley.VolleyListener;
import com.pokevian.app.smartfleet.volley.VolleyParams;


public class GetRankingRequest extends GsonRequest<Rank[]> {

    public GetRankingRequest(String memberNo, final VolleyListener<Rank[]> listener) {
        super(ServerUrl.GET_RANKING_API, Rank[].class, listener);

        VolleyParams params = new VolleyParams();
        params.put("memberNo", memberNo);
        setParams(params);

        setListener(new Response.Listener<Rank[]>() {
            @Override
            public void onResponse(Rank[] response) {
                listener.onResponse(response);
            }
        });
    }

    public GetRankingRequest(String period, String memberNo, String yyyyMMdd, final VolleyListener<Rank[]> listener) {
        super(ServerUrl.GET_RANKING_API, Rank[].class, listener);

        VolleyParams params = new VolleyParams();
        params.put("period", period);
        params.put("memberNo", memberNo);
        params.put("date", yyyyMMdd);
        setParams(params);

        setListener(new Response.Listener<Rank[]>() {
            @Override
            public void onResponse(Rank[] response) {
                listener.onResponse(response);
            }
        });
    }
}
