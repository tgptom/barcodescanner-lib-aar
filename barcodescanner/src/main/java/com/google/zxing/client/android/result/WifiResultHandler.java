/*
 * Copyright (C) 2008 ZXing authors
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

package com.google.zxing.client.android.result;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.WifiParsedResult;

import barcodescanner.xservices.nl.barcodescanner.R;

/**
 * Handles wifi access information.
 *
 * @author Vikram Aggarwal
 * @author Sean Owen
 */
public final class WifiResultHandler extends ResultHandler {

  public WifiResultHandler(CaptureActivity activity, ParsedResult result) {
    super(activity, result);
  }

  @Override
  public int getButtonCount() {
    return 0;
  }

  @Override
  public int getButtonText(int index) {
    return R.string.button_wifi;
  }

  @Override
  public void handleButtonPress(int index) {
  }

  // Display the name of the network and the network type to the user.
  @Override
  public CharSequence getDisplayContents() {
    WifiParsedResult wifiResult = (WifiParsedResult) getResult();
    return wifiResult.getSsid() + " (" + wifiResult.getNetworkEncryption() + ')';
  }

  @Override
  public int getDisplayTitle() {
    return R.string.result_wifi;
  }
}