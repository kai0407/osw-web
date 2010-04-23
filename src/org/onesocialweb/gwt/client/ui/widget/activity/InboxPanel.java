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
package org.onesocialweb.gwt.client.ui.widget.activity;

import org.onesocialweb.gwt.client.handler.ActivityButtonHandler;
import org.onesocialweb.model.activity.ActivityEntry;

import com.google.gwt.user.client.ui.Widget;

public class InboxPanel extends AbstractActivityPanel<ActivityEntry> {

	private final ActivityButtons buttons = new ActivityButtons();

	private ActivityItemView lastSelected;

	public InboxPanel() {
		// UI stuff
		addStyleName("activityPanel");

		// hide the buttons (used as overlay on focus)
		buttons.setVisible(false);
	}

	@Override
	protected Widget render(ActivityEntry activityEntry) {
		ActivityItemView sa = new ActivityItemView(activityEntry);
		sa.setButtonHandler(new ActivityButtonHandler() {
			public void handleShow(int top, ActivityItemView sa) {

				// make sure to remove the selected state. Mouseout is not
				// always captured
				if (lastSelected != null)
					lastSelected.removeStyleName("selected");
				showButtons(top);
				// force selecting the activity
				if (!sa.getStyleName().equals("selected"))
					sa.addStyleName("selected");
				lastSelected = sa;
			}

			public void handleHide() {
				hideButtons();
			}
		});
		return sa;
	}

	@Override
	protected void repaint() {
		super.repaint();
		add(buttons);
	}

	private void showButtons(int top) {
		int newtop = top - this.getAbsoluteTop();
		buttons.getElement().setAttribute("style",
				"top: " + Integer.toString(newtop) + ";");
		buttons.setVisible(true);
	}

	private void hideButtons() {
		buttons.setVisible(false);
	}

}
