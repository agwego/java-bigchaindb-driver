package com.authenteq.api;

import com.authenteq.constants.BigchainDbApi;
import com.authenteq.model.BigChainDBGlobals;
import com.authenteq.model.Votes;
import com.authenteq.util.JsonUtils;
import com.authenteq.util.NetworkUtils;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;



/**
 * The Class VotesApi.
 */
public class VotesApi {
	
	private static final Logger LOGGER = Logger.getLogger(VotesApi.class.getName());
	
	/**
	 * Gets the votes.
	 *
	 * @param blockId the block id
	 * @return the votes
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Votes getVotes(String blockId) throws IOException {
		LOGGER.info("getVotes Call :" + blockId);
		Response response = NetworkUtils.sendGetRequest(BigChainDBGlobals.getBaseUrl() + BigchainDbApi.VOTES + "?block_id=" + blockId);
		String body = response.body().string();
		response.close();
		return JsonUtils.fromJson(body, Votes.class);
	}

}
