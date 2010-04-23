/*
 *  Copyright 2010 Vodafone Group Services Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *    
 */
package org.onesocialweb.gwt.client.ui.dialog;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;

public abstract class AbstractDialog extends DialogBox {

	public AbstractDialog() {
		// set styles
		this.setStylePrimaryName("dialog");

		this.setModal(true);

		Window.addResizeHandler(new ResizeHandler() {
			public void onResize(ResizeEvent event) {
				// make sure dialog is always centered
				if (isShowing())
					center();
			}
		});

	}

	public void hide() {
		super.hide();
		onHide();
	}

	public void show() {
		super.show();
		onShow();
	}

	protected abstract void onShow();

	protected abstract void onHide();

}
