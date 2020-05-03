template=$(cat "kube/app.yml")

TOKEN_VALUE_ENCODE64=$(echo -n $TOKEN_VALUE| base64)
TOKEN_SECRET_ENCODE64=$(echo -n $TOKEN_SECRET| base64)
OAUTH_CONSUMER_ENCODE64=$(echo -n $OAUTH_CONSUMER| base64)
OAUTH_ACCESS_TOKEN_ENCODE64=$(echo -n $OAUTH_ACCESS_TOKEN| base64)

yml=$(echo "$template")

yml=`echo "$yml" | sed "s/{{TOKEN_VALUE}}/$TOKEN_VALUE_ENCODE64/g"`
yml=`echo "$yml" | sed "s/{{TOKEN_SECRET}}/$TOKEN_SECRET_ENCODE64/g"`
yml=`echo "$yml" | sed "s/{{OAUTH_CONSUMER}}/$OAUTH_CONSUMER_ENCODE64/g"`
yml=`echo "$yml" | sed "s/{{OAUTH_ACCESS_TOKEN}}/$OAUTH_ACCESS_TOKEN_ENCODE64/g"`