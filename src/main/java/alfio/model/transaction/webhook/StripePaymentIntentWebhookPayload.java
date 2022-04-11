/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.model.transaction.webhook;

import alfio.model.transaction.TransactionWebhookPayload;
import com.stripe.model.PaymentIntent;

public class StripePaymentIntentWebhookPayload implements TransactionWebhookPayload {

    private final String type;
    private final PaymentIntent payload;

    public StripePaymentIntentWebhookPayload(String type, PaymentIntent payload) {
        this.type = type;
        this.payload = payload;
    }

    @Override
    public PaymentIntent getPayload() {
        return payload;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getReservationId() {
        return payload.getMetadata().get("reservationId");
    }

    @Override
    public Status getStatus() {
        return payload.getStatus().equals("succeeded") ? Status.SUCCESS : Status.FAILURE;
    }
}
