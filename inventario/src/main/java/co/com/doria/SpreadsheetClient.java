package co.com.doria;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "products",
        url = "https://sheets.googleapis.com/v4/spreadsheets/${google.spreadSheets.id}")
public interface SpreadsheetClient {
    @RequestMapping(
        method = RequestMethod.GET,
            value = "/values/${google.spreadSheets.tabName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    SpreadsheetResponse products(@RequestParam String key);
}

